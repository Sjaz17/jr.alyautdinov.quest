package com.javarush.quest.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quest {
     Integer id;
     String text;
     Map<String, Integer> answers;
}
