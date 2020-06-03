package dev.legrug.positionalparser.converter;

import dev.legrug.positionalparser.converter.type.BigDecimalConverter;
import dev.legrug.positionalparser.converter.type.IntegerConverter;
import dev.legrug.positionalparser.converter.type.LongConverter;
import dev.legrug.positionalparser.converter.type.StringConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Register the available converter types
 * @author Márcio Gurgel (marcio.rga@gmail.com)
 *
 */
public class ConverterMapping 
{

    private static final Map<Class<?>, Converter<?>> loadedConverters = new HashMap<Class<?>, Converter<?>>();
    private ConverterMapping() {}
    
    static
    {
        loadedConverters.put(String.class, new StringConverter());
        loadedConverters.put(Integer.class, new IntegerConverter());
        loadedConverters.put(Long.class, new LongConverter());
        loadedConverters.put(BigDecimal.class, new BigDecimalConverter());
    }
    
    public static Optional<Converter> byType(Class<?> clazz)
    {
        return Optional.ofNullable(loadedConverters.get(clazz));
    }
    
    
}
