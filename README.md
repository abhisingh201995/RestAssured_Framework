<h2>API Test automation framework</h2>
<br>
<h3> Real Time Test Execution Results Using Elasticsearch & Kibana</h3>

<h4>Steps to trigger</h4>

<h5>Elastic Search</h5>
Initiate the Elastic search docker container
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.2.2

<h5>Kibana</h5>
Initiate the Kibana search docker container
docker run -p 5601:5601 -e ELASTICSEARCH_URL=http://[IP where elasticsearch is running]:9200 docker.elastic.co/kibana/kibana:6.2.2

<h5>Note:</h5> Then configure the kibana as per your reporting requirement.
<h5>Method 1</h5>
Use the docker file: command:  docker up

<h5>Method 1</h5>
<br>
<p>Create the jar: mvn clean package</p>
<br>
<p>execute the jar: java -jar AutomationFramework-1.0-SNAPSHOT.jar org.testng.TestNG testng.xml</p>


<h4>Maintainance</h4>
<p>Add your Test data under resource/ApiTestData folder</p>
<p>Add your test classes under Tests.ApiTest package</p>
<p>Maintain execution dependency via testng.xml using groups tag</p>




