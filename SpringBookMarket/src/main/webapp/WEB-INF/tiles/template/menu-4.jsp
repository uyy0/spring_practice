<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/SpringBookMarket/">Book Market</a>
			</div>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/books">Books</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/books/add">AddBook</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpringBookMarket/cart">Cart</a></li>

				<li class="nav-item">
					<sec:authorize access="isAuthenticated()">
						<form:form action="/SpringBookMarket/logout" method="post">
							<input type="submit" class="btn btn-success" value="Logout">
						</form:form>
					</sec:authorize>
				</li>
				
				<li class="nav-item">
					<sec:authorize access="!(isAuthenticated())">
						<a class="nav-link" href="/SpringBookMarket/login">Login</a>
					</sec:authorize>
				</li>
			</ul>
		</div>
</nav>