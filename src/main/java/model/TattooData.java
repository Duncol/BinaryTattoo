package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import model.phrase.PrintDirection;

@Setter
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public class TattooData {

    private final String tattooString;
    private String separator;
    private PrintDirection printDirection;
}
