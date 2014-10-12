JIRA REST Scala API
===================

This is an attempt to port the [jira-rest-java-client](https://bitbucket.org/atlassian/jira-rest-java-client) to Scala.

Disclaimer: It is a known fact in Scala community that you should reuse existing Java libraries instead of rewriting
them. In the case of `jira-rest-java-client`, using it from Scala is not that easy and porting the whole library to Scala
just took around 16 hours. Only time will prove whether this is a good idea or not, as maintaining this library with
ongoing changes on `jira-rest-java-client` needs contribution from the community.

Note that this is only the `api`, i.e. just the domain classes and client interfaces. It corresponds to `api` folder in
`jira-rest-java-client` repository. So in order to call actual REST API you need an implementation of this library.

I am working on an implementation with [ning](https://github.com/ning/async-http-client).
[Play WS](https://www.playframework.com/documentation/2.4.x/ScalaWS) is another async http client which resides inside
the Play ecosystem using the `ning` as underlying machinery.