<%@include file="common/header.jspf"%>

<c:forEach var="park" items="${parkDetails}">
	<c:url var="parkDetailsUrl" value="/parkDetails">
		<c:param name="parkCode" value="${park.parkCode}" />
	</c:url>
	<a href="${parkDetailsUrl}"><div class="media">
			<c:url var="imageUrl" value="/img/parks/${park.parkCode}.jpeg" />
			<div class="parksHome">
				<div class="media-left">
					<img src="${imageUrl}">
				</div>
				<div class="media-body">
					<h3>
						<c:out value="${park.parkName}" />
						-
						<c:out value="${park.state}" />
					</h3>
					<p>
						<c:out value="${park.parkDescription}" />
					</p>
				</div>
			</div>
		</div></a>
</c:forEach>

<%@include file="common/footer.jspf"%>