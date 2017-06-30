<%@include file="common/header.jspf"%>

<div class="surveyCompleted">
	<c:if test="${isSurveyCompleted == true}">
		<h3>
			Your vote has been submitted.
			<h3>
				<h4>
					Thank you for your participation!
					<h4>
	</c:if>
	<c:if test="${isSurveyCompleted == null}">
		<h3>
			Your vote has already been submitted.
			<h3>
				<h4>
					You can only vote once a day. Come back tomorrow to vote again!
					<h4>
	</c:if>
</div>

<%@include file="common/footer.jspf"%>