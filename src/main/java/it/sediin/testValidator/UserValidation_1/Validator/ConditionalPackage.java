package it.sediin.testValidator.UserValidation_1.Validator;

import java.lang.annotation.*;
import javax.validation.*;


//classe x la creazione della custom annotation

//Constrain significa che sto creando 1 validation constraint - validatedBy punta alla class che contiene la logica del constraint
//Target specifica su quali elementi si puo usare l'annotation, ElementType.TYPE significa classi, interfacce, enum
//Retemntion significa uanto a lungo questa annotation viene tenuta ed è disponibile al runtime atraverso la reflection
//public @interface ConditionalPackage dichiara 1 nuova annotation
//String message() default "If address is provided, hasPackage is required"; = attributo dell'annotation, valore di default e default error message se il constraint è violato

//questo serve x categorizzare i vari constraint e validarli 1 alla volta
//Class<?>[] = Class: può essere qualsiasi classe, <?>: di qualsiasi tipo, [] : un array - è quindi 1 array di qualsiasi classe e di qualsiasi tipo
// groups() default {};

//porta la metadata relativa al constraint
//Class<? extends Payload>[] payload() default {}; =


@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Constraint(validatedBy = ConditionalPackageValidatorForClass.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConditionalPackage {
    String message() default  "default error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
