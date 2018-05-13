# -*- mode: ruby -*-
# vi: set ft=ruby :

if !Vagrant.has_plugin?("vagrant-rdp")
    system('vagrant plugin install vagrant-rdp')
end
if !Vagrant.has_plugin?("vagrant-reload")
    system('vagrant plugin install vagrant-reload')
end
if !Vagrant.has_plugin?("vagrant-vbguest")
    system('vagrant plugin install vagrant-vbguest')
end
if !Vagrant.has_plugin?("vagrant-winrm-syncedfolders")
    system('vagrant plugin install vagrant-syncedfolders')
end

Vagrant.configure("2") do |config|
  config.vm.box = "~/.vagrantbox/win10_edge_for_testing.box"
  # big timeout since windows boot is very slow
  config.vm.boot_timeout = 500

  # port forward (RDP, ssh, WinRM)
  config.vm.network "forwarded_port", guest: 3389, host: 3389, id: "rdp", auto_correct: true
  config.vm.network "forwarded_port", guest: 22, host: 2222, id: "ssh", auto_correct: true
  config.vm.network "forwarded_port", guest: 5985, host: 55985, id: "winrm", auto_correct: true
  config.vm.network "forwarded_port", guest: 5986, host: 55986, id: "winrm-ssl", auto_correct: true
  config.vm.network "forwarded_port", guest: 8080, host: 8888, id: "jenkins", auto_correct: true

  config.ssh.insert_key = false

  config.vm.provider "virtualbox" do |vb|
    # first setup requires gui to be enabled so scripts can be executed in virtualbox guest screen
    #vb.gui = true
    vb.name = "win10_edge_for_testing"
    vb.customize ["modifyvm", :id, "--memory", "1024"]
    vb.customize ["modifyvm", :id, "--vram", "64"]
    vb.customize ["modifyvm", :id,  "--cpus", "2"]
    vb.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
    vb.customize ["guestproperty", "set", :id, "/VirtualBox/GuestAdd/VBoxService/--timesync-set-threshold", 10000]

    vb.customize [
      "modifyvm", :id,
      "--clipboard", "bidirectional",
      "--draganddrop", "bidirectional",
      "--ioapic", "on"
    ]
  end

  # winrm config, uses modern.ie default user/password. If other credentials are used must be changed here
  config.vm.guest = :windows
  config.ssh.sudo_command = ''

  config.vbguest.auto_update = true
  config.vbguest.no_remote = false

  config.vm.communicator = "winrm"
  config.winrm.username = "IEUser"
  config.winrm.password = "Passw0rd!"
  config.winrm.timeout = 180

  config.vm.synced_folder "./", "c:/src"

end
