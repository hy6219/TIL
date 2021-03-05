package com.exception13;

import java.io.IOException;

//자동으로 객체의 close()호출

public interface Closeable extends AutoCloseable
{
	void close() throws IOException;
}
