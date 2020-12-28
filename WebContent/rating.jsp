<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome.min.css">
<script src="${pageContext.request.contextPath}/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/star-rating.min.js" type="text/javascript"></script>

<body>
    <div class="container">
        <div class="page-header">
            <h2>Bootstrap Star Rating Examples
                <small>&copy; Kartik Visweswaran, Krajee.com</small>
            </h2>
        </div>

        <form>
            <input id="input-21b" value="4" type="text" class="rating" data-min=0 data-max=5 data-step=0.2
                data-size="lg" required title="">
            <div class="clearfix"></div>
            <hr>
        </form>
        <hr>
        <script>
            jQuery(document).ready(function () {
                $("#input-21f").rating({
                    starCaptions: function (val) {
                        if (val < 3) {
                            return val;
                        } else {
                            return 'high';
                        }
                    },
                    starCaptionClasses: function (val) {
                        if (val < 3) {
                            return 'label label-danger';
                        } else {
                            return 'label label-success';
                        }
                    },
                    hoverOnClear: false
                });
                var $inp = $('#rating-input');

                $inp.rating({
                    min: 0,
                    max: 5,
                    step: 1,
                    size: 'lg',
                    showClear: false
                });

                $('#btn-rating-input').on('click', function () {
                    $inp.rating('refresh', {
                        showClear: true,
                        disabled: !$inp.attr('disabled')
                    });
                });


                $('.btn-danger').on('click', function () {
                    $("#kartik").rating('destroy');
                });

                $('.btn-success').on('click', function () {
                    $("#kartik").rating('create');
                });

                $inp.on('rating.change', function () {
                    alert($('#rating-input').val());
                });


                $('.rb-rating').rating({
                    'showCaption': true,
                    'stars': '3',
                    'min': '0',
                    'max': '3',
                    'step': '1',
                    'size': 'xs',
                    'starCaptions': { 0: 'status:nix', 1: 'status:wackelt', 2: 'status:geht', 3: 'status:laeuft' }
                });
                $("#input-21c").rating({
                    min: 0, max: 8, step: 0.5, size: "xl", stars: "8"
                });
            });
        </script>
    </div>
</body>

</html>