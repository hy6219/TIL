##Object 클래스에 대한 정리를 이클립스에서 보면##
Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.

로 적혀져 있음! 따라서 배열은 기본형 배열이든 객체배열이든 그 원래 자료형을 반환!(이미 Cloneable이 구현되어 있음!)

+배열은 public 제어자로 오버라이딩되어 있기 때문에 직접 호출이 가능
