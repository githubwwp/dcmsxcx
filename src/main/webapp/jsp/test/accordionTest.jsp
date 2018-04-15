<!DOCTYPE html>
<html>
<head>
<title>accordionTest</title>

<!-- common jsp -->
<jsp:include page="/util/baseJsp.jsp"></jsp:include>

<!-- custom js -->


</head>
<body>
<div class="block-title">List View Accordion</div>
<div class="list accordion-list">
  <ul>
    <li class="accordion-item"><a href="#" class="item-content item-link">
        <div class="item-inner">
          <div class="item-title">Item 1</div>
        </div></a>
      <div class="accordion-item-content">
        <div class="block">
          <p>Item 1 content. Lorem ipsum dolor sit amet...</p>
        </div>
      </div>
    </li>
    <li class="accordion-item"><a href="#" class="item-content item-link">
        <div class="item-inner">
          <div class="item-title">Item 2</div>
        </div></a>
      <div class="accordion-item-content">
        <div class="block">
          <p>Item 2 content. Lorem ipsum dolor sit amet...</p>
        </div>
      </div>
    </li>
    ...
  </ul>
</div>

<!-- Separate collapsibles - omit "accordion-list" class-->
<div class="block-title">Separate Collapsibles</div>
<div class="list">
  <ul>
    <li class="accordion-item"><a href="#" class="item-content item-link">
        <div class="item-inner">
          <div class="item-title">Item 1</div>
        </div></a>
      <div class="accordion-item-content">
        <div class="block">
          <p>Item 1 content. Lorem ipsum dolor sit amet...</p>
        </div>
      </div>
    </li>
    <li class="accordion-item"><a href="#" class="item-content item-link">
        <div class="item-inner">
          <div class="item-title">Item 2</div>
        </div></a>
      <div class="accordion-item-content">
        <div class="block">
          <p>Item 2 content. Lorem ipsum dolor sit amet...</p>
        </div>
      </div>
    </li>
    ...
  </ul>
</div>

<!-- Custom Accordion -->
<div class="block-title">Custom Accordion</div>
<div class="block accordion-list custom-accordion">
  <div class="accordion-item">
    <div class="accordion-item-toggle">
      <i class="icon icon-plus">+</i>
      <i class="icon icon-minus">-</i>
      <span>Item 1</span>
    </div>
    <div class="accordion-item-content">
      <p>Item 1 content. Lorem ipsum dolor sit amet...</p>
    </div>
  </div>
  <div class="accordion-item">
    <div class="accordion-item-toggle">
      <i class="icon icon-plus">+</i>
      <i class="icon icon-minus">-</i>
      <span>Item 2</span>
    </div>
    <div class="accordion-item-content">
      <p>Item 2 content. Lorem ipsum dolor sit amet...</p>
    </div>
  </div>
</div>
</body>
</html>