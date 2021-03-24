MessageFormat 클래스 내에서 '(홑따옴표)는 이스케이프 문자로 사용되기 때문에, '를 사용하고 싶다면 ''로 연속 두번 사용해야 

예)
~~~java

String msg = "INSERT INTO "+tableName+" VALUES (''{0}'',"
				+ "''{1}'',''{2}'',''{3}'')";
~~~
