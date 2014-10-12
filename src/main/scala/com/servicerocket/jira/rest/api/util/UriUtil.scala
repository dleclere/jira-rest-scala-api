package com.servicerocket.jira.rest.api.util

import java.net.URI

object UriUtil {

  def path(uri: URI, path: String): URI = {
    val uriString = uri.toString
    val sb = new StringBuilder(uriString)
    if (!uriString.endsWith("/")) {
      sb.append('/')
    }
    sb.append(if (path.startsWith("/")) path.substring(1) else path)
    URI.create(sb.toString())
  }

}
