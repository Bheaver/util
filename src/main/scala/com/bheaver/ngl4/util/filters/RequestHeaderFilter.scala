package com.bheaver.ngl4.util.filters

import java.util

import org.springframework.stereotype.Component
import org.springframework.web.server.{ServerWebExchange, WebFilter, WebFilterChain}
import reactor.core.publisher.Mono

import scala.collection.JavaConverters

@Component
class RequestHeaderFilter extends WebFilter {
  override def filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono[Void] = {
    val header: Option[util.List[String]] = Option(exchange.getRequest.getHeaders.get("RequestId"))
    val requestId = header match {
      case Some(x) => x.get(0)
      case None => java.util.UUID.randomUUID().toString
    }
    exchange.getResponse.getHeaders.add("RequestId",requestId)
    chain.filter(exchange)
  }
}
