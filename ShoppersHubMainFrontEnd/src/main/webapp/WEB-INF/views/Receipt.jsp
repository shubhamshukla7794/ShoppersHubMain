<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br><br><br><br>


<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>ShoppersHub</strong>
                        <br>
                        Your one-stop destination
                        <br>
                        Made by:- SHUBHAM KUMAR SHUKLA
                        <br>
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Date: ${sessionScope.orderdate}</em>
                    </p>
                    <p>
                        <em>Order ID: ORD00000${sessionScope.orderId}</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listCartItems}" var="cartItem">
						<tr>
							<td>${cartItem.productName}</td>
							<td>${cartItem.quantity}</td>
							<td>&#8377;${cartItem.price}</td>
							<td>&#8377;${cartItem.quantity * cartItem.price}</td>
						</tr>
						</c:forEach>
                        
                        <tr>
                            <td> � </td>
                            <td> � </td>
                            <td class="text-right"><h4><strong>Total:�</strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>&#8377;${totalCost}</strong></h4></td>
                        </tr>
                    </tbody>
                </table>
                
            </div>
        </div>
    </div>