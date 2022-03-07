<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Formatting (like dates) -->
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<!-- form:form -->
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!-- for rendering errors on PUT routes -->
			<%@ page isErrorPage="true" %>
				<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
					<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<title>Create a Task</title>
						<link rel="stylesheet"
							href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
							integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
							crossorigin="anonymous">
					</head>

					<body>
						<div class="container">
							<h1>Log a New Workout</h1>
							<form:form action="/workout/create" method="post" modelAttribute="workout">
								<div>
									<form:label path="workoutName">Workout Name</form:label>
									<form:errors path="workoutName" class="text-danger" />
									<form:input path="workoutName" type="text" class="form-control" /> 
									<div id="exercises0">


										<form:label path="exercises[0].exerciseName">Exercise Name:</form:label>
										<form:input path="exercises[0].exerciseName" type="text" class="form-control" />
										<div id="exerciseInfos0">
											<form:label path="exercises[0].exerciseInfos[0].numberOfSets"> Set:
											</form:label>
											<form:input path="exercises[0].exerciseInfos[0].numberOfSets" type="text"
												class="form-control" />
											<form:label path="exercises[0].exerciseInfos[0].rep"> Reps:</form:label>
											<form:input path="exercises[0].exerciseInfos[0].rep" type="text"
												class="form-control" />
											<form:label path="exercises[0].exerciseInfos[0].weight"> Weight:</form:label>
											<form:input path="exercises[0].exerciseInfos[0].weight" type="text"
												class="form-control" />






										</div><button type="button" onClick="addAnotherSet(0)">Add AnotherSet</button>
									</div>
									

									<button type="button" onClick="addAnotherExercise()">Add
										AnotherExercise</button>

									<form:label path="diary">Diary Entry: </form:label>
									<form:errors path="diary" class="text-danger" />
									<form:input path="diary" type="text" class="form-control" />
								</div>


								<input type="submit" value="Submit" class="btn btn-success mt-3" />
								<a class="btn btn-primary" href="/home">Cancel</a>
							</form:form>
						</div>
					</body>
					<script>
						function addAnotherExercise() {
							var indexCount = $("div[id^=exercises]").length;
							if (indexCount) {
								var newExercise = "<hr> <div id='exercises" + indexCount + "'>";

								newExercise += "<label name='exercises[" + indexCount + "].exerciseName'>Exercise Name:</label>";
								newExercise += "<input name='exercises[" + indexCount + "].exerciseName' type='text' class='form-control' />";
								newExercise += "<div id='exerciseInfos" + indexCount + "'>";

								newExercise += "<label name='exercises[" + indexCount + "].exerciseInfos[0].numberOfSets'> Set:</label>";
								newExercise += "<input name='exercises[" + indexCount + "].exerciseInfos[0].numberOfSets' type='text' class='form-control' />";
								newExercise += "<label name='exercises[" + indexCount + "].exerciseInfos[0].rep'> Reps:</label>";
								newExercise += "<input name='exercises[" + indexCount + "].exerciseInfos[0].rep' type='text' class='form-control' />";
								newExercise += "<label name='exercises[" + indexCount + "].exerciseInfos[0].weight'> Weight:</label>";
								newExercise += "<input name='exercises[" + indexCount + "].exerciseInfos[0].weight' type='text' class='form-control' />";
								newExercise += "<button type='button' onClick='addAnotherSet(" + indexCount + ")'>Add AnotherSet</button>";

								newExercise += "</div>";
								newExercise += "</div>";
								$("#exercises" + (indexCount - 1)).after(newExercise);
							}
						}
						function addAnotherSet(exercisesIndex) {
							var indexCount = $("div[id^=exerciseInfos]").length;
							if (indexCount) {
								var newExercise = "<div id='exerciseInfos" + exercisesIndex + "'>";



								newExercise += "<label name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].numberOfSets'> Set:</label>";
								newExercise += "<input name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].numberOfSets' type='text' class='form-control' />";
								newExercise += "<label name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].rep'> Reps:</label>";
								newExercise += "<input name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].rep' type='text' class='form-control' />";
								newExercise += "<label name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].weight'> Weight:</label>";
								newExercise += "<input name='exercises[" + exercisesIndex + "].exerciseInfos[" + indexCount + "].weight' type='text' class='form-control' />";
								// newExercise += "<button type='button' onClick='addAnotherSet()'>Add AnotherSet</button>"

								newExercise += "</div>";
								$("#exercises" + (exercisesIndex)).after(newExercise);
							}
						}
					</script>

					</html>