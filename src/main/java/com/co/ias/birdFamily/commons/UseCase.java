package com.co.ias.birdFamily.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
