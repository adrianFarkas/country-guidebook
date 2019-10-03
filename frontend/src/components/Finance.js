import React from 'react';

function Finance(props) {

    return (
        <div className="detail-card">

            <h1>Finance</h1>
            <hr/>
            <div className="detail-card-left-div">



                <br />Hungary is an OECD high-income mixed economy with a very high human development index and a skilled labour force,
                with the 13th lowest income inequality in the world; furthermore it is the 14th most complex economy according to the
                Economic Complexity Index. The Hungarian economy is the 57th-largest economy in the world (out of 188 countries measured by IMF)
                with $265.037 billion annual output, and ranks 49th in the world in terms of GDP per capita measured by purchasing power parity.
                Hungary is an export-oriented market economy with a heavy emphasis on foreign trade; thus the country is the 35th largest export economy in the world.
                The country had more than $100 billion of exports in 2015, with a high trade surplus of $9.003 billion, of which 79% went to the EU and 21% was extra-EU trade.
                Hungary's productive capacity is more than 80% privately owned, with 39.1% overall taxation, which funds the country's welfare economy. On the expenditure side,
                household consumption is the main component of GDP and accounts for 50% of its total, followed by gross fixed capital formation with 22% and government
                expenditure with 20%. In 2009 Hungary, due to strong economic difficulties, had to request the help of the IMF for about € 9 billion.
<br/><br/>
                Hungary continues to be one of the leading nations in Central and Eastern Europe for attracting foreign direct investment:
                the inward FDI in the country was $119.8 billion in 2015, while Hungary invests more than $50 billion abroad. As of 2015,
                the key trading partners of Hungary were Germany, Austria, Romania, Slovakia, France, Italy, Poland and the Czech Republic.
                Major industries include food processing, pharmaceuticals, motor vehicles, information technology, chemicals, metallurgy, machinery,
                electrical goods, and tourism (in 2014 Hungary welcomed 12.1 million international tourists). Hungary is the largest electronics
                producer in Central and Eastern Europe. Electronics manufacturing and research are among the main drivers of innovation and economic
                growth in the country. In the past 20 years Hungary has also grown into a major center for mobile technology, information security, and
                related hardware research.The employment rate in the economy was 68.7% in January 2017, the employment structure shows the
                characteristics of post-industrial economies, 63.2% of the employed workforce work in the service sector, industry contributed by 29.7%,
                while agriculture employed 7.1%. The unemployment rate was 3.8% in September–November 2017, down from 11% during the financial crisis of
                2007–08. Hungary is part of the European single market which represents more than 508 million consumers. Several domestic commercial policies
                are determined by agreements among European Union members and by EU legislation.
            </div>
            <div className="detail-card-right-div">
                <h4>State debt in million Euro</h4>
                <img
                    src="https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-government-debt-to-gdp.png?s=hundebt2gdp&v=201904231545V20190821&lang=all" className="details-card-right-images"/>

                <h4>Average Salary in HUF</h4>
                <img
                    src="https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-wages.png?s=hungarywag&v=201910020957V20190821" className="details-card-right-images"/>
                <h4>Minimum Wage in Euro</h4>
                <img
                    src="https://d3fy651gv2fhd3.cloudfront.net/charts/hungary-minimum-wages.png?s=hungaryminwag&v=201904021542V20190821" className="details-card-right-images"/>


            </div>
        </div>
    );
}

export default Finance;
