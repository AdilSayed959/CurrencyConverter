package in.hatio.currency.currency_converter.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import in.hatio.currency.currency_converter.model.ConversionResponse;
import in.hatio.currency.currency_converter.utils.ApiUrlBuilder;

@Service
public class CurrencyConverterService {

	@Autowired
	private ApiUrlBuilder apiUrlBuilder;

	public Object fetchExchangeRate(String base) {
		String latestRatesUrl = apiUrlBuilder.buildLatestRatesUrl(base);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(latestRatesUrl, Object.class);
	}

	public ConversionResponse getConvertedAmount(String from, String to, double amount) {
		try {
			var rates = fetchExchangeRate(from);
			var rateMap = (Map<String, Double>) ((Map<String, Object>) rates).get("rates");

			if (!rateMap.containsKey(to)) {
				throw new IllegalArgumentException("Invalid target currency: " + to);
			}

			double rate = rateMap.get(to);
			double convertedAmount = amount * rate;
			return new ConversionResponse(from, to, amount, convertedAmount);
		} catch (RestClientException e) {
			throw new RuntimeException("External Api is not available.");
		}
	}

}
