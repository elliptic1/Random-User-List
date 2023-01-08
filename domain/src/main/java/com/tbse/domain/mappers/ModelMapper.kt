package com.tbse.domain.mappers

/**
 * Created by toddsmith on 1/7/23.
 */
interface ModelMapper<I, out O> {
    fun map(input: I): O
}