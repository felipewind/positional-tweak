package dev.legrug.positionalparser.pojo;

import dev.legrug.positionalparser.annotation.PositionalField;
import lombok.*;

/**
 * Flat pojo example
 * @author Márcio Gurgel (marcio.rga@gmail.com)
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class FlatPojo 
{
    @PositionalField(length = 10)
    private String firstName;
    
    @PositionalField(length = 10)
    private String lastName;


}
