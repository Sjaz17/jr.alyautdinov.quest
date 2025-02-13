package com.javarush.quest.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quest {
     Long id;
     String text;
     List<Answer> answers;
}
