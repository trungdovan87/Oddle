package com.oddle.tdv.boot.face.util;

/**
 * Created by trungdovan on 20/01/2017.
 */
@FunctionalInterface
public interface FunctionalGateway<T, R> {
  R apply(T request);
}
