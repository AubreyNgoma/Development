$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/AEM.Feature");
formatter.feature({
  "name": "Searching google for a key word and confirming it exists",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Google Search",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I navigate to google search page",
  "keyword": "Given "
});
formatter.match({
  "location": "AEM_StepDefinitions.i_navigate_to_google_search_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the key word AEM and enter",
  "keyword": "When "
});
});