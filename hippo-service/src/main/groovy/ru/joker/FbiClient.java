package ru.joker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.ZonedDateTime;

/**
 * @author tolkv
 * @since 26/11/15
 */
@FeignClient("fbi-service")
public interface FbiClient {
  @RequestMapping(value = "/fink",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  void fink(Fink request);

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  class Fink {
    int hippoCount;
    int parrotFee;
  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  class FinkResponse {
    ZonedDateTime lastFinkDate;
  }
}
