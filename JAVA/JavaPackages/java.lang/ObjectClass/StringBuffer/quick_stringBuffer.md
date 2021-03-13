*StringBuffer: 멀티스레드에 안전하도록 동기화되어있어서, 멀티스레드로 작성되지 않았다면 성능이 저하됨
StringBuilder : 쓰레드의 동기화만 
하지만!!

성능향상이 반드시 필요한 경우를 제외하고 기존코드에서 StringBuffer를 StringBuilder로 바꿀 필요는 없음!
