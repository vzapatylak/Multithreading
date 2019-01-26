package com.epam.reader;

import com.epam.entity.BaseEntity;

import java.nio.file.Path;
import java.util.List;

public interface Reader<T extends BaseEntity> {

    List<T> parse(Path filePath);
}
