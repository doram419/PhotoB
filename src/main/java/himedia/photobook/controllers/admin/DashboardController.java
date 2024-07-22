package himedia.photobook.controllers.admin;


import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.UsersVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 최근 주문 내역 데이터 생성 (예시)
        List<OrdersVo> orderList = createRecentOrders();

        // 최근 회원 가입 내역 데이터 생성 (예시)
        List<UsersVo> memberList = createRecentMembers();

        // 데이터를 request 속성에 저장하여 JSP 파일에 전달
        request.setAttribute("orderList", orderList);
        request.setAttribute("memberList", memberList);

        // JSP 파일로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/admin/admin_dashboard.jsp").forward(request, response);
    }

    // 최근 주문 내역을 생성하는 메서드 (예시)
    private List<OrdersVo> createRecentOrders() {
        List<OrdersVo> orders = new ArrayList<>();
        orders.add(new OrdersVo("1001", "user001", "홍길동", new Date(), "배송 완료", 10L));
        // 추가 주문 데이터 생성 및 추가

        return orders;
    }

    // 최근 회원 가입 내역을 생성하는 메서드 (예시)
    private List<UsersVo> createRecentMembers() {
        List<UsersVo> members = new ArrayList<>();
        members.add(new UsersVo("user001", "이영희", "010-1234-5678"));
        // 추가 회원 데이터 생성 및 추가

        return members;
    }
}