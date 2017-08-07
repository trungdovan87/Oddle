package com.oddle.tdv.boot.face.util;

import java.util.Optional;

/**
 * Created by trungdovan on 20/01/2017.
 */
@FunctionalInterface
public interface OptionalGateway<T, R> {
  Optional<R> apply(T request);
}
