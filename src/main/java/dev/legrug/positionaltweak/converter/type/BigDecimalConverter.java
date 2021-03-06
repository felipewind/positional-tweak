package dev.legrug.positionaltweak.converter.type;

import dev.legrug.positionaltweak.converter.Converter;
import dev.legrug.positionaltweak.parser.vo.PositionalFieldVO;
import dev.legrug.positionaltweak.parser.vo.PositionalMonetaryVO;
import dev.legrug.positionaltweak.util.PaddingGenerator;

import java.math.BigDecimal;

public class BigDecimalConverter implements Converter<BigDecimal> {

    public static final int DECIMAL_NOT_INFORMED = -1;
    public static final String REGEX_THAT_THREATS_ZERO_ON_LEFT = "^0+(?!$)";
    public static final String DEFAULT_DECIMA_SEPARATOR_WHEN_TO_STRING = ".";

    @Override
    public BigDecimal fromPositional(String input, PositionalFieldVO positionalFieldVO) {
        PositionalMonetaryVO positionalMonetaryVO = positionalFieldVO.getPositionalMonetaryVO();
        String rawInput = input
                .replaceAll(REGEX_THAT_THREATS_ZERO_ON_LEFT, "")
                .replace(positionalMonetaryVO.getDecimalSeparator(), "");

        int numberOfDecimalPlaces = positionalMonetaryVO.getNumberOfDecimalPlaces();
        if (numberOfDecimalPlaces != DECIMAL_NOT_INFORMED) {
            String valueWithSeparator = insertDotAsDecimalSeparator(rawInput, numberOfDecimalPlaces);
            return new BigDecimal(valueWithSeparator);
        }
        return new BigDecimal(rawInput);
    }

    private String insertDotAsDecimalSeparator(String inputWithoutZerosOnLeft, int numberOfDecimalPlaces) {
        return inputWithoutZerosOnLeft
                .replaceAll("^(.{" + numberOfDecimalPlaces + "})", "$1" + ".");
    }

    @Override
    public String toPositional(BigDecimal pojoFieldValue, PositionalFieldVO positionalFieldVO) {
        String rawPojoValueAsString = pojoFieldValue.toString()
                .replace(DEFAULT_DECIMA_SEPARATOR_WHEN_TO_STRING, positionalFieldVO.getPositionalMonetaryVO().getDecimalSeparator());
        String correctNumberOfZeros = PaddingGenerator.generateZeros(positionalFieldVO, rawPojoValueAsString);
        return correctNumberOfZeros + rawPojoValueAsString;
    }





}
