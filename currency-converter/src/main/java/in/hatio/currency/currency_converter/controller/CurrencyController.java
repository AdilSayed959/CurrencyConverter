package in.hatio.currency.currency_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.hatio.currency.currency_converter.model.ConversionRequest;
import in.hatio.currency.currency_converter.model.ConversionResponse;
import in.hatio.currency.currency_converter.service.CurrencyConverterService;

@RestController
@RequestMapping("/api")
public class CurrencyController {

	@Autowired
	private CurrencyConverterService currencyConverterService;

	@GetMapping("/rates")
	public Object getExchangeRate(@RequestParam String base) {
		return currencyConverterService.fetchExchangeRate(base);
	}

	@PostMapping("/convert")
	public ConversionResponse convertAmount(@RequestBody ConversionRequest conversionRequest) {

		return currencyConverterService.getConvertedAmount(conversionRequest.getFrom(), conversionRequest.getTo(),
				conversionRequest.getAmount());

	}
}
