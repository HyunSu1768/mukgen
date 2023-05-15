package com.example.mukgen.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Bad Request
    PASSWORD_SAME(400,"Same Password"),
    BAD_REQUEST(400, "Bad request"),

    // UnAuthorized
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    // Forbidden
    BOARD_WRITER_MISMATCH(403, "Board writer mismatch"),
    REVIEW_WRITER_MISMATCH(403, "Review writer mismatch"),
    COMMENT_WRITER_MISMATCH(403, "Comment writer mismatch"),

    // Not Found
    USER_NOT_FOUND(404,"User not found"),
    PASSWORD_MISMATCH(404, "Password mismatch"),
    BOARD_NOT_FOUND(404, "Board not found"),
    RICE_NOT_FOUND(404,"Meal not found"),
    REVIEW_NOT_FOUND(404,"Review not found"),
    BOARD_COMMENT_NOT_FOUND(404,"BoardComment not found"),
    DELIVERY_PARTY_NOT_FOUND(404,"Delivery Party not found"),

    // Conflict
    USER_ALREADY_EXISTS(409, "User already exists"),
    REVIEW_ALREADY_EXISTS(409,"Review already exists"),

    // Internal Server Error
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;

    private final String message;

}
