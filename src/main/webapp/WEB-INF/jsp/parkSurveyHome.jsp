<%@include file="common/header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="actionUrl" value="/parkSurveyHome" />
<form:form method="POST" action="${actionUrl}" modelAttribute="survey">
	<div class="badAlert">
		<c:out value="${message}" />
	</div>
	<div class="surveyForm">
		<h2>Nation Park Survey!</h2>
		<label for="parkName"><h4>Select your favorite Park:</h4></label> <br>
		<select name="parkName">
			<c:forEach var="park" items="${parkDetails}">
				<%-- <input type="radio" name="parkName" value="${park.parkName}" checked> ${park.parkName} <br> --%>
				<option value="${park.parkName}">${park.parkName}</option>
			</c:forEach>
		</select> <br> <br> <label for="emailAddress">What is your
			email Address?</label> <br> <input type="text" name="emailAddress">
		<span class="errors"><form:errors path="emailAddress"
				cssClass="error" /></span> <br> <br> <label
			for="stateOfResidence">What is your state of residence?</label> <br>
		<select name="stateOfResidence">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select> <br> <br> <label for="activityLevel"> Select your
			activity level:</label> <br> <input type="radio" name="activityLevel"
			value="inactive" checked> Inactive <br> <input
			type="radio" name="activityLevel" value="sedetary" checked>
		Sedentary <br> <input type="radio" name="activityLevel"
			value="active" checked> Active <br> <input type="radio"
			name="activityLevel" value="extremelyactive" checked>
		Extremely active <br>
	</div>
	<br>
	<div class="surveyForm">
		<input type="submit" name="submit" value="Submit Survey" />
	</div>
</form:form>
<br>

<%@include file="common/footer.jspf"%>
