
baseball
-----------

구조
클라이언트 : Vue.js, Nuxt.js
서버 :  Spring Boot
DB : H2

Methods List

# 게임 정보 등록
    - submit() //문제와 최대시도 횟수 등록 함수
    - formNumberValidator() //숫자 유효성체크 메소드
    - genProblemNumber() //문제 생성 메소드
    - checkProblemNumber //이전 게임에서 사용된 정답과 같은 숫자를 생성하지 않기 위해 체크하는 메소드

# 게임 시작
    - 현재 게임상태 요청
        - getBestHistory() //현재 게임 최고기록 정보저장 함수
        - callGameInfo() //현재 게임 정보 요청 함수
    - 게임 시도
        - submitAnswer() // 정답 제출 함수
        - removeChar() //한자리 숫자만 입력받게 하는 함수
        - bindNumbers() //각 인풋 창에서 정답으로 받은 숫자를 하나의 스트링으로 합치는 함수
        - addDataToLogs() //props 데이터 넘기기 위한 값을 저장하기위한 함수
        - evalAnswer() //점수 판단 메소드

# 게임 종료
# 게임 별 최고기록 요청
    -callAllHistory() //게임별 최고기록을 요청하는 함수
    -getBestHistory() //게임별 최고기록을 가져오는 메소드
    -setFormattedDate() //데이트포맷 변경 함수

