-- src/main/resources/data.sql
-- 관리자 계정 생성
INSERT INTO users (username, email, password_hash, role, created_at, updated_at)
VALUES ('admin', 'admin@example.com', 'password', 'ADMIN', NOW(), NOW());

-- 기본 카테고리 생성
INSERT INTO categories (name, description, color, display_order, created_at, updated_at)
VALUES ('Backend', '백엔드 개발 관련 포스트', '#28a745', 1, NOW(), NOW()),
       ('Frontend', '프론트엔드 개발 관련 포스트', '#007bff', 2, NOW(), NOW());

-- 샘플 게시글 생성
INSERT INTO posts (title, content, status, category_id, user_id, created_at, updated_at)
VALUES ('첫 번째 게시글', '## 안녕하세요! \n\n이것은 첫 번째 테스트 게시글입니다.', 'PUBLISHED', 1, 1, NOW(), NOW()),
       ('두 번째 게시글', '## 두 번째 게시글입니다. \n\n카테고리는 Frontend 입니다.', 'PUBLISHED', 2, 1, NOW(), NOW());