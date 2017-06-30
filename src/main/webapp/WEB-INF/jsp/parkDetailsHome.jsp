<%@include file="common/header.jspf"%>

<c:url var="parkDetailsUrl" value="/parkDetails">
	<c:param name="parkCode" value="${park.parkCode}" />
</c:url>
<div class="media">
	<c:url var="imageUrl" value="/img/parks/${park.parkCode}.jpeg" />
	<div class="media-left">
		<img src="${imageUrl}">
	</div>
	<div class="media-body">
		<h3>
			<c:out value="${park.parkName}" />
			-
			<c:out value="${park.state}" />
		</h3>
		<h5>
			<c:out value="${park.parkDescription}" />
		</h5>
		<h3>Park Information:</h3>
		Acreage:
		<c:out value="${park.acreage}" />
		<br> Elevation(ft.):
		<c:out value="${park.elevationInFeet}" />
		<br> Total trail distance(mi):
		<c:out value="${park.milesOfTrail}" />
		<br> Number of Campsites:
		<c:out value="${park.numberOfCampsites}" />
		<br> Climate:
		<c:out value="${park.climate}" />
		<br> Year Founded:
		<c:out value="${park.yearFounded}" />
		<br> Annual Visitors:
		<c:out value="${park.annualVisitorCount}" />
		<br> Inspirational Quote: "
		<c:out value="${park.inspirationalQuote}" />
		" -
		<c:out value="${park.inspirationalQuoteSource}" />
		<br> Entry Fee: $
		<c:out value="${park.entryFee}" />
		<br> Number of Animal Species:
		<c:out value="${park.numberOfAnimalSpecies}" />
	</div>
</div>
<br>
<div class="forecastHead">
	<h3>Five Day Forecast:</h3>
</div>
<div class="fiveDay">
	<table class="forecastTable">
		<tr>
			<c:forEach var="day" items="${weather}">
				<th><c:out value="${day.day}" /></th>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="dayForecast" items="${weather}">
				<td><c:url var="weatherUrl"
						value="/img/weather/${dayForecast.forecast}.png" /> <img
					src="${weatherUrl}"> <br> <c:if test="${isF == true}">
High: <c:out value="${dayForecast.highTempF}" />°F
<br>
Low: <c:out value="${dayForecast.lowTempF}" />°F</c:if> <c:if
						test="${isF == false}">
High: <c:out value="${dayForecast.highTempC}" />°C
<br>
Low: <c:out value="${dayForecast.lowTempC}" />°C</c:if> <br> <c:choose>
						<c:when test="${dayForecast.forecast == 'snow'}">
Pack snowshoes!<br>
						</c:when>
						<c:when test="${dayForecast.forecast == 'rain'}">
Pack rain gear and wear waterproof shoes!<br>
						</c:when>
						<c:when test="${dayForecast.forecast == 'sunny'}">
Bring sunblock!<br>
						</c:when>
						<c:when test="${dayForecast.forecast == 'thunderstorms'}">
Seek shelter and avoid hiking on exposed ridges!<br>
						</c:when>
						<c:when test="${dayForecast.highTempF >= 75}">
Bring an extra gallon of water!<br>
						</c:when>
						<c:when
							test="${dayForecast.highTempF - dayForecast.lowTempF >= 20}">
Wear breathable layers!<br>
						</c:when>
						<c:when test="${dayForecast.lowTempF < 20}">
Beware of frigid temperatures!<br>
						</c:when>
						<c:otherwise>
							<c:out value="  " />
							<br>
						</c:otherwise>
					</c:choose></td>
			</c:forEach>
		</tr>
	</table>
</div>
<div class="surveySubmit">
	<c:if test="${isF == true}">
		<c:url var="parkDetailsUrl" value="/parkDetailsTempSwitch">
			<c:param name="parkCode" value="${park.parkCode}" />
		</c:url>
		<form method="POST" action="${parkDetailsUrl}">
			<br> <input class="button" type="submit"
				value="Convert to Celsius" />
		</form>
	</c:if>
</div>
<br>
<div class="surveySubmit">
	<c:if test="${isF == false}">
		<c:url var="parkDetailsUrl" value="/parkDetailsTempSwitch">
			<c:param name="parkCode" value="${park.parkCode}" />
		</c:url>
		<form method="POST" action="${parkDetailsUrl}">
			<input class="button" type="submit" value="Convert to Fahrenheit" />
		</form>
	</c:if>
</div>
<br>
<br>

<%@include file="common/footer.jspf"%>