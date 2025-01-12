package in.hatio.currency.currency_converter.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ApiUrlBuilder {

	@Value("${api.base-url}")
	private String baseUrl;

	@Value("${api.access-key}")
	private String accessKey;

	public String buildLatestRatesUrl(String base) {

		return UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("access_key", accessKey).queryParam("base", base)
				.toUriString();

	}

}
