package com.exception13;

import java.io.IOException;

//�ڵ����� ��ü�� close()ȣ��

public interface Closeable extends AutoCloseable
{
	void close() throws IOException;
}
