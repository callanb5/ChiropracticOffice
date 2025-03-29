<%-- ==================================================
    Lucas Lawless
    Callan Bramblett
    CTC-Chiropractic
    index.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
        <link href="styles.css" rel="stylesheet" > 
    </head>

    <body>  
        <nav class="navbar">
            <div class="logo">
                <a href="">
                    <img src="img/CTC_Logo.png" alt="logo">
                </a>   
            </div>

            <div class="mNav">
                <ul>
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="F&Q.jsp">CONTACT US</a></li>
                    <li><a href="F&Q.jsp">HELP</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li><a href="Patient-Login.jsp" class="logBtn">Login<div>&#8594;</div></a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
        <main>
               <section class="mb">
                <div class="mb1">
                    <section>
                        <h2>Chattahoochee Tech Chiropractic</h2>
                        <p><b>You should be in control of your body. CTC Chiropractic offers a full
                         suite of cosmetic services to give your body relief. With treatments tailored
                          to your unique needs, our team can help you achieve the comfort you desire.</b></p>
                        <a href="Patient-Login.jsp">
                            <button>Learn More</button>
                        </a>
                    </section>
                </div>
                
                <div class="mb2">
                    <section></section>

                    <section>
                        <h2><b>Our Mission</b></h2>
                        <p><b> Maintaining a healthy body is essential throughout life and CTC Chiropractic
                         is committed to providing comprehensive care to all. From checkups to advanced 
                         treatments, we ensure your physical health lasts!</b></p>
                        <a href="New_P-Account.jsp">
                            <button>Sign Up Now</button>
                        </a>
                    </section>
                </div>
            </section>

            <section class="Testimonials">
            
<div class="slideshow-container">
<h1>Testimonials from Patients like You!</h1><br>
  <!-- Full-width images with number and caption text -->
  <div class="Slides fade">
   <div class="slides">
                <h3>Kingsley Knapp</h3>
                <p> Just started going to CT-Chiropractic and alreaad I'm noticing a differance with my neck pain.
                </p>
            </div>
  </div>

  <div class="Slides fade">
  <div class="slides">
                <h3>Anaya Garner</h3>
                <p> Been going to seeing Dr. Dean once a month for the past year and I feel like I regained
                10 years back!  
                </p>
            </div>
  </div>

  <div class="Slides fade">
     <div class="slides">
                <h3>Hamzah Odonell</h3>
                <p>Dr. Odom is someone I have come to trust with handling my lower back problems. 
                </p>

            </div>
  </div><br>

  <%-- <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br> --%>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>
          
            
            </section><br>
        </main>
        
        <footer>
            <section class="mFoot">
                <div class="fLogo">
                    <img src="img/CTC_Logo.png" alt="">
                </div>
                
                <section class="sFoot">
                    <div>
                        <h4>Campaign</h4>
                        <ul>
                            <li><a href="">Appointments</a></li>
                            <li><a href="">Pharmacy</a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                    </div>
        
                    <div>
                        <h4>About us</h4>
                        <ul>
                            <li><a href="">Staff</a></li>
                            <li><a href="">Open hours</a></li>
                            <li><a href="">Policies</a></li>
                            <li><a href="">Locations</a></li>
                        </ul>
                    </div>
    
                    <div>
                        <h4>Contact us</h4>
                        <ul>
                            <li><a href="">(404) 456-7890</a></li>
                            <li><a href="">info@CTC-Chiropractic.com</a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                    </div>
                </section>
    
                <div class="follow">
                    <h4>Follow us on</h4>
                    <ul>
                        <li><a href="">Gmail</a></li>
                        <li><a href="">Facebook</a></li>
                        <li><a href="">Instagram</a></li>
                        <li><a href="">Twitter</a></li>
                    </ul>
                </div>
            </section>
    
            <section>
                <p>&copy;CTC Chiropractic 2025. All rights reserved.</p>
            </section>
        </footer>


         <script>

         //auto slide code for slide
let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("slides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 10000); // Change Div every ten seconds
}

</script>

    </body>

   
</html>