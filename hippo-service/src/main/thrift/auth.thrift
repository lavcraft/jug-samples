namespace java info.developerblog.services.auth

exception TUnauthorizedException {
    1: string message
}

struct TAuthToken {
    1: required string token
}

struct TUser {
    1: required i64 userId
}