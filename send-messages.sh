#!/bin/bash

# 여러 메시지를 빠르게 전송하여 멀티스레드 Consumer 동작 확인

PORT=8080
ENDPOINT="http://localhost:${PORT}/api/orders"
MESSAGE_COUNT=20

echo "🚀 ${MESSAGE_COUNT}개의 주문 메시지를 빠르게 전송합니다..."
echo "📍 Endpoint: ${ENDPOINT}"
echo ""

for i in $(seq 1 $MESSAGE_COUNT)
do
  price=$((i * 1000))
  echo "📦 메시지 #${i} 전송 중... (name: Product-${i}, price: ${price})"
  
  curl -X POST "${ENDPOINT}" \
    -H "Content-Type: application/json" \
    -d "{\"name\": \"Product-${i}\", \"price\": ${price}}" \
    -s -o /dev/null &
done

wait

echo ""
echo "✅ 모든 메시지 전송 완료!"
echo ""
echo "📋 애플리케이션 로그를 확인하여 여러 스레드가 동작하는지 확인하세요:"
echo "   예상되는 로그 패턴:"
echo "   - [...EndpointContainer#0-0-C-1] Received message ..."
echo "   - [...EndpointContainer#0-1-C-1] Received message ..."
echo "   - [...EndpointContainer#0-2-C-1] Received message ..."
echo ""
echo "💡 스레드 이름에서 '#0-X-C-1'의 X 값이 0, 1, 2로 다르게 나타나면 성공입니다!"

