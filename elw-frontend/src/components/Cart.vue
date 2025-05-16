<template>
    <div class="cart-page">
      <!-- Header -->
      <header>
        <div class="logo">EDU<span>102</span></div>
        <div class="search-bar">
          <input type="text" placeholder="Tìm khóa học...">
          <button>🔍</button>
        </div>
        <nav>
          <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Khóa học</a></li>
            <li><a href="#">Giảng viên</a></li>
          </ul>
        </nav>
        <div class="auth-buttons">
          <button class="btn login-btn">Đăng nhập</button>
          <button class="btn signup-btn">Đăng ký</button>
          <div class="cart-icon active">
            <i>🛒</i>
            <span class="cart-count">{{ cartItems.length }}</span>
          </div>
        </div>
      </header>
  
      <!-- Cart Container -->
      <div class="cart-container">
        <div class="cart-header">
          <h1>Giỏ hàng của bạn</h1>
          <p>{{ cartItems.length }} khóa học trong giỏ hàng</p>
        </div>
  
        <div class="cart-content">
          <div class="cart-items">
            <!-- Cart Item -->
            <div class="cart-item" v-for="(item, index) in cartItems" :key="index">
              <div class="item-checkbox">
                <input type="checkbox" v-model="item.selected">
              </div>
              <div class="item-image">
                <img :src="item.image" :alt="item.title">
              </div>
              <div class="item-details">
                <h3>{{ item.title }}</h3>
                <p class="item-description">{{ item.description }}</p>
              </div>
              <div class="item-actions">
                <div class="item-price" :class="{ free: item.price === 0 }">{{ formatPrice(item.price) }} VND</div>
                <button class="remove-btn" @click="removeFromCart(index)"><i>🗑️</i> Xóa</button>
              </div>
            </div>
          </div>
  
          <!-- Cart Total and Checkout Button -->
          <div class="cart-total">
            <div class="total">
              <span>Thành tiền:</span>
              <span>{{ formatPrice(totalPrice) }} VND</span>
            </div>
            <a href="payment.html" class="checkout-btn" @click.prevent="checkout">Thanh toán ngay</a>
          </div>
        </div>
  
        <!-- Recommended Courses -->
        <div class="recommended-courses">
          <h2>Có thể bạn quan tâm</h2>
          <div class="courses-grid">
            <!-- Course Card -->
            <div class="course-card" v-for="(course, index) in recommendedCourses" :key="index">
              <div class="course-image">
                <img :src="course.image" :alt="course.title">
                <div class="wishlist-btn" :class="{ 'wishlist-active': course.isWishlisted }" @click="toggleWishlist(index)">❤</div>
              </div>
              <div class="course-content">
                <h3 class="course-title">{{ course.title }}</h3>
                <p class="course-info">{{ course.description }}</p>
                <div class="course-price">
                  <div class="price" :class="{ free: course.price === 0 }">{{ formatPrice(course.price) }} VND</div>
                  <div class="buy-btn" @click="addToCart(course)">Mua ngay</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  
      <!-- Footer -->
      <footer>
        <div class="footer-content">
          <div>
            <div class="footer-logo">EDU<span>102</span></div>
            <p class="footer-description">Nền tảng học tập tài chính & công nghệ trên đám mây</p>
          </div>
        </div>
        <div class="copyright">
          © {{ currentYear }}. EDU102. All rights reserved.
        </div>
      </footer>
    </div>
  </template>
  
  <script>
  export default {
    name: 'GioHang',
    data() {
      return {
        cartItems: [
          {
            title: 'Quản lý tài chính cá nhân',
            description: 'Khóa học quản lý tài chính cá nhân',
            image: 'https://via.placeholder.com/300x150',
            price: 5000,
            selected: true
          },
          {
            title: 'Lập trình JavaScript cơ bản',
            description: 'Khóa học lập trình web front-end cơ bản với JavaScript',
            image: 'https://via.placeholder.com/300x150',
            price: 5000,
            selected: true
          },
          {
            title: 'Quản lý tài chính cá nhân (Free)',
            description: 'Khóa học quản lý tài chính cá nhân cơ bản',
            image: 'https://via.placeholder.com/300x150',
            price: 0,
            selected: true
          }
        ],
        recommendedCourses: [
          {
            title: 'Phân tích dữ liệu với Python',
            description: 'Học cách phân tích và trực quan hóa dữ liệu sử dụng Python',
            image: 'https://via.placeholder.com/300x150',
            price: 7000,
            isWishlisted: false
          },
          {
            title: 'Đầu tư chứng khoán cơ bản',
            description: 'Tìm hiểu các phương pháp đầu tư chứng khoán hiệu quả',
            image: 'https://via.placeholder.com/300x150',
            price: 6000,
            isWishlisted: false
          },
          {
            title: 'React.js cho người mới bắt đầu',
            description: 'Khóa học xây dựng ứng dụng web với React',
            image: 'https://via.placeholder.com/300x150',
            price: 8000,
            isWishlisted: false
          },
          {
            title: 'Excel cho phân tích tài chính',
            description: 'Sử dụng Excel để phân tích và lập kế hoạch tài chính',
            image: 'https://via.placeholder.com/300x150',
            price: 5500,
            isWishlisted: false
          }
        ]
      };
    },
    computed: {
      totalPrice() {
        return this.cartItems
          .filter(item => item.selected)
          .reduce((total, item) => total + item.price, 0);
      },
      currentYear() {
        return new Date().getFullYear();
      }
    },
    methods: {
      formatPrice(price) {
        return price.toLocaleString('vi-VN');
      },
      removeFromCart(index) {
        this.cartItems.splice(index, 1);
      },
      addToCart(course) {
        const newItem = {
          title: course.title,
          description: course.description,
          image: course.image,
          price: course.price,
          selected: true
        };
        this.cartItems.push(newItem);
      },
      toggleWishlist(index) {
        this.recommendedCourses[index].isWishlisted = !this.recommendedCourses[index].isWishlisted;
      },
      checkout() {
        alert('Đang chuyển đến trang thanh toán');
        // Trong ứng dụng thực tế, có thể sử dụng router để chuyển trang
        // this.$router.push('/payment');
      }
    }
  };
  </script>
  
  <style scoped>
  /* Reset CSS */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
  
  body {
    color: #333;
    line-height: 1.6;
    background-color: #f7f9fc;
  }
  
  /* Header Styles */
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1rem 5%;
    background-color: white;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
  }
  
  .logo {
    font-weight: bold;
    font-size: 1.5rem;
    color: #002855;
    cursor: pointer;
  }
  
  .logo span {
    color: #ff6b00;
  }
  
  .search-bar {
    display: flex;
    width: 35%;
  }
  
  .search-bar input {
    width: 100%;
    padding: 0.5rem 1rem;
    border: 1px solid #ddd;
    border-radius: 20px;
    outline: none;
  }
  
  .search-bar button {
    background-color: #002855;
    color: white;
    border: none;
    border-radius: 50%;
    width: 35px;
    height: 35px;
    margin-left: -35px;
    cursor: pointer;
  }
  
  nav ul {
    display: flex;
    list-style: none;
  }
  
  nav ul li {
    margin-left: 1.5rem;
  }
  
  nav ul li a {
    text-decoration: none;
    color: #333;
    font-weight: 500;
  }
  
  .cart-icon {
    position: relative;
    margin-left: 15px;
    font-size: 1.5rem;
    cursor: pointer;
  }
  
  .cart-icon.active {
    color: #002855;
  }
  
  .cart-count {
    position: absolute;
    top: -8px;
    right: -8px;
    background-color: #ff6b00;
    color: white;
    font-size: 0.7rem;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .auth-buttons {
    display: flex;
    align-items: center;
  }
  
  .auth-buttons .btn {
    padding: 0.5rem 1rem;
    margin-left: 0.5rem;
    border-radius: 4px;
    cursor: pointer;
    font-weight: 500;
  }
  
  .login-btn {
    border: 1px solid #002855;
    color: #002855;
    background: none;
  }
  
  .signup-btn {
    background-color: #002855;
    color: white;
    border: none;
  }
  
  /* Cart Page Specific Styles */
  .cart-container {
    max-width: 1200px;
    margin: 2rem auto;
    padding: 0 1rem;
  }
  
  .cart-header {
    margin-bottom: 2rem;
    text-align: center;
  }
  
  .cart-header h1 {
    color: #002855;
    font-size: 2rem;
    margin-bottom: 0.5rem;
  }
  
  .cart-header p {
    color: #666;
  }
  
  .cart-items {
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    padding: 1.5rem;
  }
  
  .cart-item {
    display: grid;
    grid-template-columns: 40px 120px 1fr auto;
    gap: 1.5rem;
    padding: 1.5rem 0;
    border-bottom: 1px solid #eee;
    align-items: center;
  }
  
  .cart-item:last-child {
    border-bottom: none;
  }
  
  .item-checkbox {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .item-checkbox input[type="checkbox"] {
    width: 20px;
    height: 20px;
    cursor: pointer;
  }
  
  .item-image {
    width: 120px;
    height: 80px;
    overflow: hidden;
    border-radius: 4px;
  }
  
  .item-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .item-details h3 {
    font-size: 1.1rem;
    margin-bottom: 0.5rem;
    color: #002855;
  }
  
  .item-description {
    color: #666;
    font-size: 0.9rem;
    margin-bottom: 0.8rem;
  }
  
  .item-actions {
    text-align: right;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  
  .item-price {
    font-weight: bold;
    font-size: 1.1rem;
    margin-bottom: 1rem;
  }
  
  .item-price.free {
    color: #28a745;
  }
  
  .remove-btn {
    padding: 0.5rem;
    margin-bottom: 0.5rem;
    border: none;
    background: none;
    color: #666;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    cursor: pointer;
    transition: color 0.3s ease;
  }
  
  .remove-btn:hover {
    color: #dc3545;
  }
  
  .remove-btn i {
    margin-right: 0.3rem;
  }
  
  /* Cart Total and Checkout Button */
  .cart-total {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 1.5rem;
    padding: 1rem;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  }
  
  .cart-total .total {
    font-weight: bold;
    color: #002855;
    font-size: 1.2rem;
  }
  
  .cart-total .total span:last-child {
    margin-left: 0.5rem;
  }
  
  .checkout-btn {
    background-color: #002855;
    color: white;
    border: none;
    padding: 0.8rem 2rem;
    border-radius: 4px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
    text-decoration: none;
  }
  
  .checkout-btn:hover {
    background-color: #001f42;
  }
  
  /* Recommended Courses */
  .recommended-courses {
    margin-top: 3rem;
  }
  
  .recommended-courses h2 {
    color: #002855;
    font-size: 1.5rem;
    margin-bottom: 1.5rem;
    text-align: center;
    position: relative;
  }
  
  .recommended-courses h2::after {
    content: '';
    position: absolute;
    height: 3px;
    width: 50px;
    background-color: #002855;
    bottom: -10px;
    left: 50%;
    transform: translateX(-50%);
  }
  
  .courses-grid {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 1.5rem;
    margin-top: 2rem;
  }
  
  .course-card {
    background-color: white;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 2px 10px rgba(0,0,0,0.05);
    transition: transform 0.3s ease;
  }
  
  .course-card:hover {
    transform: translateY(-5px);
  }
  
  .course-image {
    position: relative;
    height: 150px;
    overflow: hidden;
  }
  
  .course-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .wishlist-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    background-color: white;
    border-radius: 50%;
    width: 30px;
    height: 30px;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    transition: all 0.3s ease;
  }
  
  .wishlist-btn.wishlist-active {
    color: red;
  }
  
  .course-content {
    padding: 1rem;
  }
  
  .course-title {
    font-size: 1rem;
    margin-bottom: 0.5rem;
    font-weight: 600;
    color: #002855;
  }
  
  .course-info {
    font-size: 0.8rem;
    color: #666;
    margin-bottom: 0.8rem;
  }
  
  .course-price {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .price {
    font-weight: bold;
  }
  
  .price.free {
    color: #28a745;
  }
  
  .buy-btn {
    background-color: #002855;
    color: white;
    padding: 0.3rem 0.8rem;
    border-radius: 4px;
    cursor: pointer;
    font-size: 0.8rem;
    transition: background-color 0.3s ease;
    text-decoration: none;
  }
  
  .buy-btn:hover {
    background-color: #001f42;
  }
  
  /* Footer */
  footer {
    background-color: #002855;
    color: white;
    padding: 2rem 5% 1rem;
    margin-top: 3rem;
  }
  
  .footer-content {
    display: flex;
    justify-content: space-between;
    padding-bottom: 2rem;
  }
  
  .footer-logo {
    font-size: 1.5rem;
    font-weight: bold;
    margin-bottom: 1rem;
  }
  
  .footer-logo span {
    color: #ff6b00;
  }
  
  .footer-description {
    max-width: 300px;
    opacity: 0.8;
    margin-bottom: 1rem;
  }
  
  .copyright {
    text-align: center;
    padding-top: 1rem;
    border-top: 1px solid rgba(255,255,255,0.2);
    opacity: 0.7;
    font-size: 0.9rem;
  }
  
  /* Responsive Design */
  @media (max-width: 1024px) {
    .courses-grid {
      grid-template-columns: repeat(3, 1fr);
    }
  }
  
  @media (max-width: 900px) {
    .cart-content {
      grid-template-columns: 1fr;
    }
  }
  
  @media (max-width: 768px) {
    .cart-item {
      grid-template-columns: 40px 100px 1fr;
    }
    
    .item-actions {
      grid-column: span 3;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
      margin-top: 1rem;
    }
    
    .item-price {
      margin-bottom: 0;
    }
    
    .courses-grid {
      grid-template-columns: repeat(2, 1fr);
    }
    
    .cart-total {
      flex-direction: column;
      gap: 1rem;
    }
    
    .checkout-btn {
      width: 100%;
      text-align: center;
    }
  }
  
  @media (max-width: 576px) {
    .courses-grid {
      grid-template-columns: 1fr;
    }
    
    .search-bar {
      display: none;
    }
    
    .cart-item {
      grid-template-columns: 40px 1fr;
    }
    
    .item-image {
      width: 100%;
      height: 150px;
    }
    
    .item-actions {
      grid-column: span 2;
    }
  }
  </style>