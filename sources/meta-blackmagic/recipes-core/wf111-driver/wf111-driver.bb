DESCRIPTION = "WF111 driver and bin utils"
SECTION = "wireless driver"
LICENSE = "CLOSED"

INSANE_SKIP_${PN} = "already-stripped"
DEPENDS = "linux-stable"

inherit module

SRC_URI = " \
	file://wf111-linux-driver_5.2.2-r4_armv7-a.tar.gz \	
"

do_compile () {
	cd ${WORKDIR}/wf111-linux-driver_5.2.2-r4_armv7-a

	# TODO: FK: Improve this (don't hardcode the kernel version)
	make install_static KDIR=${WORKDIR}/../../linux-stable/4.9.136-r0/build ARCH=arm CROSS_COMPILE=arm-poky-linux-gnueabi-
}

do_install (){
	install -d ${D}w
	cp -rf ${WORKDIR}/wf111-linux-driver_5.2.2-r4_armv7-a/output/* ${D}
}

# TODO: FK: Improve this (don't hardcode the kernel version)
RPROVIDES_${PN} += "kernel-module-unifi-sdio-4.9.136-jumpnow"

FILES_${PN} = "/usr/* \
/lib* "