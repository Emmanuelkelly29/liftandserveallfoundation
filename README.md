# Lift and Serve All Foundation Website

A comprehensive NGO website for Lift and Serve All Foundation, dedicated to transforming the lives of children in underserved communities through education.

## 🌟 Features

### Frontend
- **Responsive Design**: Works seamlessly on desktop, tablet, and mobile devices
- **Modern UI/UX**: Clean, professional design with navy blue theme
- **Interactive Elements**: Smooth animations, hover effects, and user-friendly navigation
- **Live Chatbot**: AI-powered customer support for instant assistance
- **SEO Optimized**: Built with search engine optimization in mind

### Pages
- **Homepage**: Hero section, impact statistics, program highlights, and call-to-action
- **About Us**: Foundation story, vision, mission, team profiles, and core values
- **Programs & Impact**: Detailed program descriptions, success stories, and impact metrics
- **Get Involved**: Volunteer opportunities, partnership options, and membership programs
- **Donate**: Secure donation system with multiple payment options
- **News & Blog**: Latest updates, success stories, and educational content
- **Contact Us**: Contact form, office information, and social media links
- **FAQs**: Comprehensive answers to frequently asked questions

### Backend (Spring Boot)
- **RESTful API**: Complete backend API for donation processing and user management
- **Database Integration**: MySQL/PostgreSQL support with JPA/Hibernate
- **Payment Processing**: Integration with PayPal, Stripe, and Flutterwave
- **Email Services**: Automated email notifications and newsletter management
- **Security**: Spring Security implementation for data protection
- **Admin Panel**: Management interface for donations, volunteers, and content

## 🚀 Getting Started

### Prerequisites
- Node.js (for frontend development)
- Java 17+ (for backend)
- MySQL 8.0+ or PostgreSQL 12+
- Maven 3.6+

### Frontend Setup
1. Clone the repository
2. Open the project in your preferred code editor
3. Open `index.html` in a web browser
4. For development, use a local server (e.g., Live Server extension in VS Code)

### Backend Setup
1. Navigate to the `backend` directory
2. Configure database connection in `application.properties`
3. Set up payment gateway API keys
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## 🛠️ Technology Stack

### Frontend
- **HTML5**: Semantic markup and structure
- **CSS3**: Modern styling with Flexbox and Grid
- **JavaScript**: Interactive functionality and API integration
- **Font Awesome**: Icons and visual elements
- **Google Fonts**: Montserrat font family

### Backend
- **Spring Boot 3.2.0**: Java framework for backend development
- **Spring Data JPA**: Database abstraction layer
- **Spring Security**: Authentication and authorization
- **Spring Mail**: Email service integration
- **MySQL/PostgreSQL**: Database management
- **Maven**: Dependency management and build tool

### Payment Integration
- **Stripe**: Credit card processing
- **PayPal**: Online payment processing
- **Flutterwave**: African payment gateway

## 📁 Project Structure

```
liftandserveallfoundation/
├── index.html              # Homepage
├── about.html              # About Us page
├── programs.html           # Programs & Impact page
├── involved.html           # Get Involved page
├── donate.html             # Donation page
├── news.html               # News & Blog page
├── contact.html            # Contact Us page
├── faqs.html               # FAQs page
├── styles.css              # Main stylesheet
├── script.js               # JavaScript functionality
└── backend/                # Spring Boot backend
    ├── src/main/java/
    │   └── org/liftandserveallfoundation/
    │       ├── LiftAndServeAllFoundationApplication.java
    │       ├── controller/
    │       ├── model/
    │       ├── repository/
    │       └── service/
    ├── src/main/resources/
    │   └── application.properties
    └── pom.xml
```

## 🎨 Design System

### Colors
- **Primary**: Navy Blue (#001F54)
- **Secondary**: White (#FFFFFF)
- **Accent**: Light Blue (#3A9BDC)
- **Text**: Dark Gray (#333333)
- **Background**: Light Gray (#F8F9FA)

### Typography
- **Font Family**: Montserrat (Google Fonts)
- **Weights**: 300, 400, 500, 600, 700

### Components
- Responsive navigation with mobile hamburger menu
- Interactive buttons with hover effects
- Card-based layouts for content sections
- Form validation and user feedback
- Loading states and animations

## 🔧 Configuration

### Environment Variables
Set the following environment variables for production:

```bash
# Database
DB_URL=jdbc:mysql://localhost:3306/liftandserveallfoundation
DB_USERNAME=your_username
DB_PASSWORD=your_password

# Payment Gateways
STRIPE_API_KEY=sk_live_your_stripe_secret_key
STRIPE_PUBLISHABLE_KEY=pk_live_your_stripe_publishable_key
PAYPAL_CLIENT_ID=your_paypal_client_id
PAYPAL_CLIENT_SECRET=your_paypal_client_secret
FLUTTERWAVE_PUBLIC_KEY=your_flutterwave_public_key
FLUTTERWAVE_SECRET_KEY=your_flutterwave_secret_key

# Email
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_app_password

# Security
ADMIN_PASSWORD=your_secure_admin_password
```

## 📱 Responsive Design

The website is fully responsive and optimized for:
- **Desktop**: 1200px+ (full layout)
- **Tablet**: 768px - 1199px (adapted layout)
- **Mobile**: 320px - 767px (mobile-first design)

## 🔒 Security Features

- **HTTPS**: SSL/TLS encryption for all communications
- **Input Validation**: Server-side validation for all forms
- **SQL Injection Prevention**: Parameterized queries
- **XSS Protection**: Input sanitization
- **CSRF Protection**: Cross-site request forgery prevention
- **Secure Headers**: Security headers implementation

## 📊 Analytics & Monitoring

- **Google Analytics**: Website traffic analysis
- **Performance Monitoring**: Page load time optimization
- **Error Tracking**: Error logging and monitoring
- **User Behavior**: User interaction tracking

## 🚀 Deployment

### Frontend Deployment
1. Upload HTML, CSS, and JavaScript files to web server
2. Configure web server (Apache/Nginx)
3. Set up SSL certificate
4. Configure domain DNS

### Backend Deployment
1. Build the Spring Boot application:
   ```bash
   mvn clean package
   ```
2. Deploy to cloud platform (AWS, Google Cloud, Azure)
3. Configure database connection
4. Set up environment variables
5. Configure load balancer and SSL

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For support and questions:
- **Email**: michael@liftandservefoundation.com
- **Phone**: +2348031114594 (Nigeria) | +1 (208) 992-6233 (USA)
- **Website**: [Lift and Serve All Foundation](https://liftandserveallfoundation.org)

## 🙏 Acknowledgments

- Font Awesome for icons
- Google Fonts for typography
- Spring Boot community for backend framework
- All contributors and supporters of Lift and Serve All Foundation

---

**Lift and Serve All Foundation** - Transforming the lives of children in underserved communities through education.

<nav class="navbar">
    <div class="nav-container">
        <div class="nav-logo">
            <a href="index.html">
                <img src="logo.jpg" alt="Lift and Serve All Foundation Logo" class="logo-img">
            </a>
            <span>Lift and Serve All Foundation</span>
        </div>
        <ul class="nav-menu">
            <li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
            <li class="nav-item"><a href="about.html" class="nav-link">About Us</a></li>
            <li class="nav-item"><a href="programs.html" class="nav-link">Programs & Impact</a></li>
            <li class="nav-item"><a href="donate.html" class="nav-link">Donate</a></li>
            <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
        </ul>
        <div class="hamburger">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
    </div>
</nav>
