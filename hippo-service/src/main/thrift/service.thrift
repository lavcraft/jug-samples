namespace java info.developerblog.services.user

include "auth.thrift"

struct TFbiResponse {
    1: required string lastFink
}

service TFbiService {
    TFbiResponse fink(
        1: required auth.TAuthToken user, 2: required i32 hippoCount, 3: required i32 fee
    ) throws (
            99: auth.TUnauthorizedException ue
        )
}