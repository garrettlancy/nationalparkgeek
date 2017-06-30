<%@include file="common/header.jspf"%>

<div class="surveyResultsMain">
	<h2>Favorite Parks Survey Results</h2>
	<table class="surveyResults">
		<tr>
			<th class="surveyParkName">Park Name</th>
			<th class="surveyParkVotes">Number of Votes</th>
		</tr>
		<c:forEach items="${surveyResults}" var="results">
			<tr>
				<td><c:out value="${results.parkName}" /></td>
				<td class="surveyVote"><c:out value="${results.voteCount}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="common/footer.jspf"%>
