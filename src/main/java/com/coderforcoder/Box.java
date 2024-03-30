package com.coderforcoder;

import com.coderforcoder.Ball;

public record Box<T extends Ball>(T content) { }
