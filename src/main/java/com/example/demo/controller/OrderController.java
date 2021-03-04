package com.example.demo.controller;

import com.example.demo.VO.LogisticsVO;
import com.example.demo.VO.request.OrderRequestVO;
import com.example.demo.VO.response.OrderResponseVO;
import com.example.demo.VO.request.AddLogisticsRequestVO;
import com.example.demo.VO.response.OrderInfoResponseVO;
import com.example.demo.VO.response.OrderLogisticsResponseVO;
import com.example.demo.VO.response.OrdersResponseVO;
import com.example.demo.aspect.RequireAuth;
import com.example.demo.common.Const;
import com.example.demo.common.Enum.OrderTypeEnum;
import com.example.demo.common.Enum.UserTypeEnum;
import com.example.demo.common.response.ServerResponse;
import com.example.demo.model.Logistics;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.LogisticsService;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/order/")
public class OrderController {

    private final LogisticsService logisticsService;

    private final OrderService orderService;

    public OrderController(OrderService orderService, LogisticsService logisticsService) {
        this.orderService = orderService;
        this.logisticsService = logisticsService;
    }

    @RequireAuth
    @RequestMapping(value = "buyer", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<OrdersResponseVO> queryBuyOrder(HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<OrdersResponseVO> response;
        try {
            List<Order> orderList = orderService.queryOrderByBuyer(user.getName());
            OrdersResponseVO ordersResponseVO = new OrdersResponseVO();
            ordersResponseVO.setOrderList(orderList);
            response = ServerResponse.createBySuccess(ordersResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "seller", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<OrdersResponseVO> querySellOrder(HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<OrdersResponseVO> response;
        try {
            List<Order> orderList = orderService.queryOrderBySeller(user.getName());
            OrdersResponseVO ordersResponseVO = new OrdersResponseVO();
            ordersResponseVO.setOrderList(orderList);
            response = ServerResponse.createBySuccess(ordersResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<OrderInfoResponseVO> queryOrderInfoByOrderID(@RequestParam("orderId") Long orderId,
                                                                       HttpSession session){
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<OrderInfoResponseVO> response;
        try {
            Order order = orderService.queryOrderInfoByOrderId(orderId);
            //Todo:检查用户权限
            OrderInfoResponseVO orderInfoResponseVO = new OrderInfoResponseVO();
            orderInfoResponseVO.setOrder(order);
            response = ServerResponse.createBySuccess(orderInfoResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "logistics", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<OrderLogisticsResponseVO> queryLogisticsByOrderID(@RequestParam("orderId") Long orderId,
                                                                            HttpSession session){
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<OrderLogisticsResponseVO> response;
        try {
            List<Logistics> logisticsList = logisticsService.queryLogisticsIdByOrderId(orderId);

            //Todo:检查用户权限
            OrderLogisticsResponseVO orderLogisticsResponseVO = new OrderLogisticsResponseVO();
            orderLogisticsResponseVO.setLogisticsList(logisticsList);
            response = ServerResponse.createBySuccess(orderLogisticsResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(value = "logistics", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addLogisticsByOrderID(@RequestBody AddLogisticsRequestVO addLogisticsRequestVO,
                                                                                  HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER); // TODO：
        ServerResponse<String> response;
        try {
            Order order = orderService.queryOrderInfoByOrderId(addLogisticsRequestVO.getOrderId());

            List<LogisticsVO> logisticsList = addLogisticsRequestVO.getLogisticsList();
            if (order.getOrderTypeEnum() == OrderTypeEnum.MATERIAL) {
                for (LogisticsVO logistics : logisticsList) {
                    logisticsService.createMaterialLogistics(logistics.getLogisticsId(),logistics.getMaterialIdList(),
                            logistics.getDeparture(), logistics.getDestination(), addLogisticsRequestVO.getOrderId());
                }
            } else if (order.getOrderTypeEnum() == OrderTypeEnum.PRODUCT) {
                for (LogisticsVO logistics : logisticsList) {
                    logisticsService.createProductLogistics(logistics.getLogisticsId(),logistics.getProductIdList(),
                            logistics.getDeparture(), logistics.getDestination(), addLogisticsRequestVO.getOrderId());
                }
            }

            response = ServerResponse.createBySuccess("SUCCESS");
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

    @RequireAuth
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<OrderResponseVO> createNewOrder(@RequestBody OrderRequestVO orderRequestVO,
                                                          HttpSession session) {
        User user = (User) session.getAttribute(Const.CUR_USER);
        ServerResponse<OrderResponseVO> response;
        try {
            if (!orderRequestVO.checkArguments()) {
                response = ServerResponse.createByErrorMessage("arguments wrong");
            }
            Order orderReturn = null;
            if (orderRequestVO.getOrderTypeEnum() == OrderTypeEnum.MATERIAL) {
                orderReturn = orderService.createMaterialOrder(orderRequestVO.getSeller(), user.getName(),
                        orderRequestVO.getGoodsList(), orderRequestVO.getDestination());
            } else if(orderRequestVO.getOrderTypeEnum() == OrderTypeEnum.PRODUCT) {
                orderReturn = orderService.createProductOrder(orderRequestVO.getSeller(), user.getName(),
                        orderRequestVO.getGoodsList(), orderRequestVO.getDestination());
            }
            OrderResponseVO orderResponseVO = new OrderResponseVO();
            orderResponseVO.setOrder(orderReturn);
            response = ServerResponse.createBySuccess(orderResponseVO);
        } catch (Exception e) {
            response = ServerResponse.createByErrorMessage(e.getMessage());
        }
        return response;
    }

}
