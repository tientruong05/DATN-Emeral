<template>
    <div class="payment-page">
      <!-- Header -->
      <header>
        <div class="logo">EDU<span>102</span></div>
        <div class="search-bar">
          <input type="text" placeholder="Tìm khóa học..." v-model="searchQuery">
          <button @click="search">🔍</button>
        </div>
        <nav>
          <ul>
            <li><router-link to="/">Trang chủ</router-link></li>
            <li><router-link to="/courses">Khóa học</router-link></li>
            <li><router-link to="/instructors">Giảng viên</router-link></li>
          </ul>
        </nav>
        <div class="auth-buttons">
          <button class="btn login-btn" @click="openLoginModal">Đăng nhập</button>
          <button class="btn signup-btn" @click="openSignupModal">Đăng ký</button>
          <div class="cart-icon" @click="goToCart">
            <i>🛒</i>
            <span class="cart-count">{{ cartItemCount }}</span>
          </div>
        </div>
      </header>
  
      <!-- Payment Container -->
      <div class="payment-container">
        <div class="payment-header">
          <h1>Thanh toán</h1>
          <p>Hoàn tất thanh toán để nhận khóa học ngay!</p>
        </div>
  
        <div class="payment-items">
          <div 
            v-for="(item, index) in cartItems" 
            :key="index" 
            class="payment-item"
          >
            <span class="item-name">{{ item.name }} x{{ item.quantity }}</span>
            <span :class="['item-price', { free: item.price === 0 }]">
              {{ formatPrice(item.price) }} VND
            </span>
          </div>
        </div>
  
        <div class="payment-total">
          <span>Tổng cộng:</span>
          <span>{{ formatPrice(totalAmount) }} VND</span>
        </div>
  
        <div class="payment-qr">
          <img :src="qrCodeImage" alt="QR Code">
          <div class="bank-info">
            <p><span class="bank-name">Ngân hàng:</span> {{ bankInfo.name }}</p>
            <p><span class="account-name">Chủ tài khoản:</span> {{ bankInfo.accountHolder }}</p>
            <p><span class="account-number">Số tài khoản:</span> {{ bankInfo.accountNumber }}</p>
            <p><span class="account-number">Nội dung chuyển khoản:</span> {{ transferContent }}</p>
          </div>
          <p class="note">
            • Lưu ý: Nhập chính xác số tiền <span>{{ formatPrice(totalAmount) }}</span>, nội dung <span>{{ transferContent }}</span> khi chuyển khoản.
          </p>
        </div>
  
        <button @click="cancelPayment" class="cancel-btn">Hủy</button>
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
    name: 'PaymentPage',
    data() {
      return {
        searchQuery: '',
        cartItemCount: 3,
        cartItems: [
          { name: 'Quản lý tài chính cá nhân', price: 5000, quantity: 1 },
          { name: 'Lập trình JavaScript cơ bản', price: 5000, quantity: 1 },
          { name: 'Quản lý tài chính cá nhân (Free)', price: 0, quantity: 1 }
        ],
        bankInfo: {
          name: 'TMC Việt Nam Thịnh Vượng - Ngân hàng số CAKE by VPBank',
          accountHolder: 'TRUONG MINH TIEN',
          accountNumber: '0382871562'
        },
        transferContent: 'CSBRJ22FP67 Thanh toan 448739',
        qrCodeImage: 'https://via.placeholder.com/200x200?text=QR+Code'
      }
    },
    computed: {
      totalAmount() {
        return this.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0)
      },
      currentYear() {
        return new Date().getFullYear()
      }
    },
    methods: {
      formatPrice(price) {
        return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
      },
      search() {
        console.log('Tìm kiếm:', this.searchQuery)
        // Thực hiện tìm kiếm
      },
      openLoginModal() {
        console.log('Mở modal đăng nhập')
        // Logic mở modal đăng nhập
      },
      openSignupModal() {
        console.log('Mở modal đăng ký')
        // Logic mở modal đăng ký
      },
      goToCart() {
        console.log('Chuyển đến trang giỏ hàng')
        this.$router.push('/cart')
      },
      cancelPayment() {
        console.log('Hủy thanh toán')
        this.$router.push('/cart')
      }
    }
  }
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
  
  /* Payment Page Styles */
  .payment-container {
    max-width: 800px;
    margin: 2rem auto;
    padding: 2rem;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  }
  
  .payment-header {
    text-align: center;
    margin-bottom: 2rem;
  }
  
  .payment-header h1 {
    color: #002855;
    font-size: 2rem;
    margin-bottom: 0.5rem;
  }
  
  .payment-header p {
    color: #666;
    font-size: 0.9rem;
  }
  
  .payment-items {
    margin-bottom: 2rem;
  }
  
  .payment-item {
    display: flex;
    justify-content: space-between;
    padding: 1rem 0;
    border-bottom: 1px solid #eee;
  }
  
  .payment-item:last-child {
    border-bottom: none;
  }
  
  .item-name {
    font-weight: 500;
    color: #002855;
  }
  
  .item-price {
    font-weight: bold;
  }
  
  .item-price.free {
    color: #28a745;
  }
  
  .payment-total {
    display: flex;
    justify-content: space-between;
    padding: 1rem 0;
    font-weight: bold;
    color: #002855;
    border-top: 2px solid #002855;
    margin-bottom: 2rem;
  }
  
  .payment-qr {
    text-align: center;
    padding: 1.5rem;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
  }
  
  .payment-qr img {
    width: 200px;
    height: 200px;
    margin-bottom: 1rem;
  }
  
  .payment-qr .bank-info {
    margin-bottom: 1.5rem;
  }
  
  .bank-info p {
    font-size: 0.9rem;
    margin-bottom: 0.5rem;
    color: #333;
  }
  
  .bank-info .bank-name {
    color: #ff6b00;
    font-weight: bold;
  }
  
  .bank-info .account-name {
    font-weight: 500;
  }
  
  .bank-info .account-number {
    font-weight: 500;
    color: #002855;
  }
  
  .payment-qr .note {
    font-size: 0.85rem;
    color: #666;
    margin-top: 1rem;
    line-height: 1.4;
  }
  
  .payment-qr .note span {
    color: #ff6b00;
    font-weight: 500;
  }
  
  .cancel-btn {
    display: block;
    margin: 1.5rem auto 0;
    padding: 0.8rem 2rem;
    background-color: #dc3545;
    color: white;
    border: none;
    border-radius: 4px;
    font-weight: bold;
    cursor: pointer;
    text-decoration: none;
    text-align: center;
    width: fit-content;
    transition: background-color 0.3s ease;
  }
  
  .cancel-btn:hover {
    background-color: #c82333;
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
  @media (max-width: 768px) {
    .payment-container {
      padding: 1rem;
    }
  
    .payment-header h1 {
      font-size: 1.5rem;
    }
  
    .payment-qr img {
      width: 150px;
      height: 150px;
    }
  
    .cancel-btn {
      width: 100%;
    }
  }
  
  @media (max-width: 576px) {
    .search-bar {
      display: none;
    }
  
    .payment-item {
      flex-direction: column;
      gap: 0.5rem;
    }
  }
  </style>