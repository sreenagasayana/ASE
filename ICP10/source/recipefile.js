angular.module('recipeApp', ['ngSanitize'])
    .controller('recipeCtrl', function ($scope, $http) {
        $scope.getRecipeDetails = function () {
            var recipeInput = $scope.recipe;

            // Hiding Error, Output first
            $("#fielderror").hide();
            $("#recipes").hide();

            // Validations
            if (!recipeInput) {
                // Throw error to say they should not be empty
                $scope.fielderrorhtml = "Input text cannot be empty";
                $("#fielderror").show();
                return false;
            }

            var recipesoutput = $http.get("https://api.edamam.com/search?q=" + recipeInput + "&app_id=803bd740" +
                "&app_key=f800e75c30292a82e7b45e42882bf0d8&from=0&to=10&ingr=3");
            recipesoutput.success(function (data) {

                if (data == null || data.hits == null || data.hits.length == 0) {
                    // Throw error to say no records found
                    $scope.fielderrorhtml = "No recipe details found for the input text : " + recipeInput;
                    $("#fielderror").show();
                    return false;
                }

                $scope.recipeDetails = data.hits;
                $("#recipes").show();
            })
            recipesoutput.error(function (data) {
                alert("There was some error processing your request. Please try after some time.");
            });
        }

    });